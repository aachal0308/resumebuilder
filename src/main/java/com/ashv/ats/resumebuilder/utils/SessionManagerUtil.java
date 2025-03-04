package com.ashv.ats.resumebuilder.utils;

import com.ashv.ats.resumebuilder.entity.SessionEntity;
import com.ashv.ats.resumebuilder.entity.SessionEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.time.Instant;

public class SessionManagerUtil {

    private static Map<String, SessionEntity> idSessionMap = new HashMap<>();
    private static Map<String, SessionEntity> userSessionMap = new HashMap<>();
    private static Long expiryTimeInMills = 2 * 60 * 1000l; // min * sec * millisecond

    public static String getUserIdBySession(String sessionId) {
        SessionEntity session = idSessionMap.get(sessionId);
        if (session == null) {
            return null; // Return null if session does not exist
        }
        return session.getUserId();
    }


    public static String generateSessionId(String userId) {
        SessionEntity session = new SessionEntity();
        session.setId(UUID.randomUUID().toString());
        session.setUserId(userId);
        session.setLastUsed(Instant.now().toEpochMilli());
        idSessionMap.put(session.getId(), session);
        userSessionMap.put(userId, session);
        return session.getId();
    }

    public static boolean validateSessionId(String sessionId) {
        SessionEntity session = idSessionMap.get(sessionId);
        if (session == null) return false;
        long currTime = Instant.now().toEpochMilli();
        long sessionTime = currTime - session.getLastUsed();
        if (sessionTime > expiryTimeInMills) {
            deleteSession(session);
            return false;
        }
        session.setLastUsed(currTime);
        return true;
    }

    public static void deleteSession(SessionEntity session) {
        idSessionMap.remove(session.getId());
        userSessionMap.remove(session.getUserId());
    }

    public static void deleteSession(String sessionId) {
        deleteSession(idSessionMap.get(sessionId));
    }
}

