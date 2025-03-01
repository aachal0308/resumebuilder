package com.ashv.ats.resumebuilder.utils;

import com.ashv.ats.resumebuilder.entity.SessionEnitity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.time.Instant;

public class SessionManagerUtil {
    
    private static Map<String, SessionEnitity> idSessionMap = new HashMap<>();
    private static Map<String, SessionEnitity> userSessionMap = new HashMap<>();
    private static Long expiryTimeInMills = 2 * 60 * 1000; // min * sec * millisecond
    

    public static String generateSessionId(String userId) {
        SessionEnitity session = new SessionEnitity();
        session.setId(UUID.randomUUID().toString());
        session.setUserId(userId);
        session.setLastUsed(Instant.now().toEpochMilli());
    }

    public static boolean validateSessionId(String sessionId) {
        SessionEnitity session = idSessionMap.get(sessionId);
        if(session==null) return false;
        long currTime = Instant.now().toEpochMilli();
        if(currTime - session.getLastUsed() > expiryTimeInMills) {
            deleteSession(session);
            return false;
        }
        session.setLastUsed(currTime);
        return true;
    }

    public static void deleteSession(SessionEnitity session) {
        idSessionMap.remove(session.getId);
        userSessionMap.remove(session.getUserId());
    }

    public static void deleteSession(String sessionId) {
        deleteSession(idSessionMap.get(sessionId));
    }
}

