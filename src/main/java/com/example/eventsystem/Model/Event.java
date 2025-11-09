package com.example.eventsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {
private String ID,description,startDate,endDate;
private int capacity;
}
