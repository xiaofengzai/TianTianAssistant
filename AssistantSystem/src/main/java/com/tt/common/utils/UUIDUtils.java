package com.tt.common.utils;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;

/**
 * Created by wenfeng on 2018/2/27.
 */
public class UUIDUtils {
    public static String generateOrderedUUID(){
        String uuid = Generators.timeBasedGenerator(EthernetAddress.fromInterface()).generate().toString().replace("-", "").toUpperCase();
        return uuid.substring(12,16)+uuid.substring(20,32)+uuid.substring(16,20)+uuid.substring(0,12);
    }
}
