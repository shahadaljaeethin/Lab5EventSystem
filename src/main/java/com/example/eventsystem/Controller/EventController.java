package com.example.eventsystem.Controller;

import com.example.eventsystem.Api.ApiResponse;
import com.example.eventsystem.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event system")
public class EventController {
ArrayList<Event> events = new ArrayList<>();
//-----------
@PostMapping("/add")
public ApiResponse createEvent(@RequestBody Event e){
events.add(e);
return new ApiResponse("Event "+e.getID()+" is added.");
}
@GetMapping("/get")
public ArrayList<Event> getAll(){return events;}

@PutMapping("/update/{ID}")
public ApiResponse updateEvent(@PathVariable String ID,@RequestBody Event e){
int in=0;
for(Event now: events){
if(now.getID().equals(ID)) break;
else in++;
}
events.set(in,e);
return new ApiResponse("The event got Updated successfully :)");
}

@DeleteMapping("delete/{ID}")
public ApiResponse delete(@PathVariable String ID){
    int in=0;
    for(Event now: events){
        if(now.getID().equals(ID)) break;
        else in++;
    }
events.remove(in);
return new ApiResponse("Event removed.");
}
@PutMapping("/update/capacity/{index}/{capacity}")
public ApiResponse changeCapacity(@PathVariable int index, @PathVariable int capacity)
{
int oldCap = events.get(index).getCapacity();
events.get(index).setCapacity(capacity);
return new ApiResponse("capacity updated from "+oldCap+" to "+events.get(index).getCapacity());
}
@GetMapping("/get/{ID}")
public Event searchID(@PathVariable String ID){
for(Event e:events)if(e.getID().equals(ID)) return e;
return null;
}

}
