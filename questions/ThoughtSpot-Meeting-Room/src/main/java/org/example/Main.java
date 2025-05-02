package org.example;

import org.example.entity.Meeting;
import org.example.entity.User;
import org.example.service.MeetingRoomService;
import org.example.service.notificationService.impl.NotifyWithEmail;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MeetingRoomService meetingRoomService = new MeetingRoomService(new NotifyWithEmail());

        // add meeting rooms...
        meetingRoomService.addMeetingRoom("101", "Conference Room A", 10, 1, "North Wing");
        meetingRoomService.addMeetingRoom("102", "Conference Room B", 20, 1, "South Wing");
        meetingRoomService.addMeetingRoom("103", "Conference Room C", 2, 2, "East Wing");

        // create users...
        User user1 = new User("Soumak", "abc@gmail.com");
        User user2 = new User("Himanshu", "def@gmail.com");
        User user3 = new User("Raj", "ghi@gmail.com");
        User user4 = new User("Shyam", "shjhjj@gmail.com");
        User user5 = new User("Kartik", "zed@gmail.com");

        // book a meeting...
        Meeting meeting1 = new Meeting(
                "123",
                "Project Kickoff",
                List.of(user1, user2, user3),
                930,
                1030
        );
        meetingRoomService.checkAvailabilityAndSetMeeting(meeting1);

        // book a meeting...
        Meeting meeting2 = new Meeting(
                "456",
                "Sprint Planning",
                List.of(user4, user5),
                930,
                1030
        );
        meetingRoomService.checkAvailabilityAndSetMeeting(meeting2);

        // book a meeting...
        Meeting meeting3 = new Meeting(
                "123",
                "Project Kickoff 2",
                List.of(user1, user2),
                930,
                1030
        );
        meetingRoomService.checkAvailabilityAndSetMeeting(meeting3);

        // no meeting room available...
        Meeting meeting4 = new Meeting(
                "123",
                "Project Kickoff 2",
                List.of(user1, user2),
                930,
                1030
        );
        meetingRoomService.checkAvailabilityAndSetMeeting(meeting4);
    }
}