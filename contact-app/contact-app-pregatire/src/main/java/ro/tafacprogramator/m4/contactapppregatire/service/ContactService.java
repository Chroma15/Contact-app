package ro.tafacprogramator.m4.contactapppregatire.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ro.tafacprogramator.m4.contactapppregatire.entity.Contact;

@Service
public class ContactService {

    public boolean addContact(Contact c1) {
        String line = c1.getId() + ";" 
            + c1.getFirstName() + ";" 
            + c1.getLastName() + ";" 
            + c1.getPhoneNumber() + "\n";

        try {
            Files.writeString(
                Path.of("data.txt"), 
                line, 
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public List<Contact> readAllContacts() {
        var allContact = new ArrayList<Contact>();

        try {
            var allLines = Files.readAllLines(Path.of("data.txt"));

            for (String line : allLines) {
                String[] parts = line.split(";");
                Contact c1 = new Contact();
                c1.setId(Integer.parseInt(parts[0]));
                c1.setFirstName(parts[1]);
                c1.setLastName(parts[2]);
                c1.setPhoneNumber(parts[3]);

                allContact.add(c1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allContact;
    }
}
