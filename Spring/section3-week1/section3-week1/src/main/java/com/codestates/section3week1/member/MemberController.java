package com.codestates.section3week1.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/members")
public class MemberController {
    @PostMapping
    public ResponseEntity postMember(@RequestParam("email") String email,
                                     @RequestParam("name") String name,
                                     @RequestParam("phone") String phone){
        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("name", name);
        map.put("phone", phone);

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("memeber-id")long memberId){
        System.out.println("# memeberId: "+memberId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getMembers(){
        System.out.println("# get Mmebers");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
