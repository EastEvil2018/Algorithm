package Algorithm.AppFolio.MyCalendarSolution;

import Algorithm.Public.Solution.Solution;
import Algorithm.Public.Utills.PrintUtills;

import java.util.*;

public class MyCalendarSolution extends Solution {
    @Override
    public void test() {
        MyCalendar calendar = new MyCalendar("My Calendar");
        Attendee a1 = new Attendee("a1", "a1@gmail.com");
        Attendee a2 = new Attendee("a2", "a2@gmail.com");
        Attendee a3 = new Attendee("a3", "a3@gmail.com");
        Event e1 = new Event("e1", 1, 1);
        Event e2 = new Event("e2", 1, 2);
        Event e3 = new Event("e3", 2, 2);
        Event e4 = new Event("e4", 4, 1);
        Event e5 = new Event("e5", 7, 2);

        e1.addAttendee(a1);
        e1.addAttendee(a3);

        e2.addAttendee(a1);
        e2.addAttendee(a2);

        e3.addAttendee(a3);

        e4.addAttendee(a1);

        e5.addAttendee(a2);

        calendar.addEvent(e1);
        calendar.addEvent(e2);
        calendar.addEvent(e3);
        calendar.addEvent(e4);
        calendar.addEvent(e5);

        List<Attendee> l1 = new ArrayList<>();
        l1.add(a1);
        l1.add(a2);

        PrintUtills.printListOfIntArray(calendar.availableTime(l1));
    }

    private class Attendee {
        String name;
        String email;
        public Attendee(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    private class Event {
        String name;
        int startTime;
        int duration;
        HashMap<String, Attendee> attendees;
        public Event(String name, int startTime, int duration) {
            this.name = name;
            this.startTime = startTime;
            this.duration = duration;
            this.attendees = new HashMap<>();
        }

        public void addAttendee(Attendee attendee) {
            attendees.put(attendee.email, attendee);
        }

        public void removeAttendee(String email) {
            attendees.remove(email);
        }

        public boolean hasAttendee(String email) {
            return attendees.containsKey(email);
        }
    }

    private class MyCalendar {
        String name;
        List<Event> events;

        public MyCalendar(String name) {
            this.name = name;
            events = new ArrayList<>();
        }

        public void addEvent(Event e) {
            this.events.add(e);
        }

        public List<int[]> availableTime(List<Attendee> attendees) {
            List<int[]> times = new ArrayList<>();

            TreeMap<Integer, Integer> eventRecorder
                    = new TreeMap<>();

            for (Event event : events) {
                for (Attendee attendee : attendees) {
                    if (event.hasAttendee(attendee.email)) {
                        int start = event.startTime;
                        int end = event.startTime + event.duration;
                        eventRecorder.put(start,
                                eventRecorder.getOrDefault(start, 0) + 1);
                        eventRecorder.put(end,
                                eventRecorder.getOrDefault(end, 0) - 1);
                    }
                }
            }

            int curEvent = 0;

            for (Integer time : eventRecorder.keySet()) {
                if (curEvent == 0) {
                    Integer lastTime = eventRecorder.lowerKey(time);
                    if (lastTime == null)
                        lastTime = 0;
                    if (lastTime != time)
                        times.add(new int[]{lastTime, time});
                }
                curEvent += eventRecorder.get(time);
                System.out.println(time + " : " + curEvent);
            }

            return times;
        }
    }
}
