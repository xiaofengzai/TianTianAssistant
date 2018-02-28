package com.tt.authorization.manager.impl;


import com.tt.authorization.manager.TokenManager;
import com.tt.authorization.model.TokenModel;
import com.tt.common.constant.Constants;
import com.tt.common.utils.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 通过Redis存储和验证token的实现类
 * @author leeyom
 * @date 2017年10月19日 10:41
 * @see com.tt.authorization.manager.TokenManager
 */
@Component
public class RedisTokenManager implements TokenManager {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");

    @Autowired
    public void setRedis() {
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
    }

    @Override
    public TokenModel createToken(String userId) {
        //uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //时间戳
        String timestamp = SDF.format(new Date());
        //token => userId_timestamp_uuid;
        String token = userId + "_" + timestamp + "_" + uuid;
        TokenModel model = new TokenModel(userId, uuid, timestamp);
        //存储到redis并设置过期时间(有效期为2个小时)
        redisTemplate.boundValueOps(userId.toString()).set(Base64Util.encodeData(token), Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return model;
    }

    @Override
    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 3) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        String userId = param[0];
        String timestamp = param[1];
        String uuid = param[2];
        return new TokenModel(userId, uuid, timestamp);
    }

    @Override
    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String token = redisTemplate.boundValueOps(model.getUserId()).get();
        if (token == null || !(Base64Util.decodeData(token)).equals(model.getToken())) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间(2个小时)
        redisTemplate.boundValueOps(model.getUserId()).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return true;
    }

    @Override
    public void deleteToken(String userId) {
        if (redisTemplate.hasKey(userId)) {
            redisTemplate.delete(userId);
        }
    }

    @Override
    public boolean hasToken(String userId) {
        String token = redisTemplate.boundValueOps(userId).get();
        return !StringUtils.isEmpty(token);
    }


}
