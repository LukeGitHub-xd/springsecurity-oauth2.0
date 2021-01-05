package com.fxj.springsecurityoauth2.util;

import cn.hutool.cache.impl.TimedCache;
import com.fxj.springsecurityoauth2.pojo.SysUser;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
public class CacheUtil {
    private final static TimedCache<Long, SysUser> cacheUtil= cn.hutool.cache.CacheUtil.newTimedCache(30*1000*60);

    public CacheUtil() {
        cacheUtil.schedulePrune(1000*60);
    }

    public static SysUser getSysUser(Long userId){
        return cacheUtil.get(userId);
    }

    public static void setSysUser(Long userId,SysUser user){
        cacheUtil.put(userId,user);
    }

    public static void removeSysUser(Long userId){
        synchronized (userId.toString().intern()){
            cacheUtil.remove(userId);
        }
    }
}
