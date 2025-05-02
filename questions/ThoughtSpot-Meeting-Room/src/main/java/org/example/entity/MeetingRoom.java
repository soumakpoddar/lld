package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    private String meetingRoomId;
    private String meetingRoomName;
    private int capacity;
    private int floorNumber;
    private String wing;
    private List<Meeting> meetingRoomCalender;

    public MeetingRoom(String meetingRoomId, String meetingRoomName, int capacity, int floorNumber, String wing) {
        this.meetingRoomId = meetingRoomId;
        this.meetingRoomName = meetingRoomName;
        this.capacity = capacity;
        this.floorNumber = floorNumber;
        this.wing = wing;
        this.meetingRoomCalender = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        meeting.setMeetingRoomId(meetingRoomId);
        meetingRoomCalender.add(meeting);
        meetingRoomCalender.sort((o1, o2) -> {
            if (o1.getStartTime() == o2.getStartTime()) {
                return Integer.compare(o1.getEndTime(), o2.getEndTime());
            }
            return Integer.compare(o1.getStartTime(), o2.getStartTime());
        });
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Meeting> getMeetingRoomCalender() {
        return meetingRoomCalender;
    }

    public String getMeetingRoomName() {
        return meetingRoomName;
    }

    public void printCalender() {
        System.out.println("Meeting Room: " + meetingRoomName);
        for (Meeting meeting : meetingRoomCalender) {
            System.out.println("Meeting " + meeting.getMeetingName() + " from " + meeting.getStartTime() + " to " + meeting.getEndTime());
        }
    }

    public String getMeetingRoomId() {
        return meetingRoomId;
    }
}
