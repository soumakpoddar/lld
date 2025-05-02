package org.example.service;

import org.example.entity.Meeting;
import org.example.entity.MeetingRoom;
import org.example.service.notificationService.INotifier;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoomService {
    private final List<MeetingRoom> meetingRooms;
    private final INotifier notificationService;

    public MeetingRoomService(INotifier notificationService) {
        this.notificationService = notificationService;
        meetingRooms = new ArrayList<>();
    }

    public void addMeetingRoom(String meetingRoomId, String meetingRoomName, int capacity, int floorNumber, String wing) {
        MeetingRoom meetingRoom = new MeetingRoom(meetingRoomId, meetingRoomName, capacity, floorNumber, wing);
        meetingRooms.add(meetingRoom);
    }

    public void checkAvailabilityAndSetMeeting(Meeting meeting) {
        MeetingRoom meetingRoom = null;
        for (MeetingRoom room : meetingRooms) {
            if (room.getCapacity() >= meeting.getParticipants().size()) {
                boolean isAvailable = true;
                for (Meeting existingMeeting : room.getMeetingRoomCalender()) {
                    if ((meeting.getStartTime() < existingMeeting.getEndTime() && meeting.getEndTime() > existingMeeting.getStartTime())) {
                        isAvailable = false;
                        break;
                    }
                }
                if (isAvailable) {
                    meetingRoom = room;
                    break;
                }
            }
        }
        if (meetingRoom != null) {
            meetingRoom.addMeeting(meeting);
            System.out.println("Meeting room booked successfully: " + meetingRoom.getMeetingRoomName() + " for meeting " + meeting.getMeetingName());
            MeetingRoom finalMeetingRoom = meetingRoom;
            meeting.getParticipants()
                    .forEach(user -> notificationService.notify("Meeting booked for " + meeting.getMeetingName() + " in " + finalMeetingRoom.getMeetingRoomName(), user));
        } else {
            System.out.println("No meeting room available!!!");
        }
    }
}
