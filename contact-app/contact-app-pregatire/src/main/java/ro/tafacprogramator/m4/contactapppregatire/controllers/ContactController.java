package ro.tafacprogramator.m4.contactapppregatire.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ro.tafacprogramator.m4.contactapppregatire.entity.Contact;
import ro.tafacprogramator.m4.contactapppregatire.service.ContactService;

@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("/contact")
    HashMap<String, Object> addNewContact(@RequestBody Contact c1) {
        var result = new HashMap<String, Object>();
        
        if (c1.getFirstName() == null) {
            result.put("success", false);
            result.put("message", "missing first name");
            return result;
        }
        
        if (!contactService.addContact(c1)) {
            result.put("success", false);
            result.put("message", "save failed");
            return result;
        }

        result.put("success", true);
        return result;
    }

    @GetMapping("/contacts")
    @CrossOrigin
    List<Contact> listAllContacts() {
        var allContact = contactService.readAllContacts();

        return allContact;
    }



    @GetMapping("/example-contact")
    Contact getExampleContact() {
        var c1 = new Contact();

        c1.setId(1);
        c1.setFirstName("John");

        return c1;
    }

    @GetMapping("/example-multiple-contacts")
    List<Contact> getExampleMultipleContact() {
        var c1 = new Contact();

        c1.setId(1);
        c1.setFirstName("John");

        var allContacts = new ArrayList<Contact>();

        allContacts.add(c1);
        allContacts.add(c1);
        allContacts.add(c1);

        return allContacts;
    }

}
