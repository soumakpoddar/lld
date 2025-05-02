package org.example.entity;

import java.util.List;

public class Meeting {
    private String meetingId;
    private String meetingName;
    private String meetingRoomId;
    private List<User> participants;
    private int startTime;
    private int endTime;

    public Meeting(String meetingId, String meetingName, List<User> participants, int startTime, int endTime) {
        this.meetingId = meetingId;
        this.meetingName = meetingName;
        this.participants = participants;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setMeetingRoomId(String meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public int getCapacity() {
        return participants.size();
    }
}
