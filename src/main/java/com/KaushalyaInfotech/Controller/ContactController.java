package com.KaushalyaInfotech.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KaushalyaInfotech.Entity.ContactList;
import com.KaushalyaInfotech.Service.ContactService;
import com.KaushalyaInfotech.Service.EmailService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@Autowired
	private EmailService emailService;

	@PostMapping("/save-Contact")
	public ContactList saveContactList(@RequestBody ContactList contactList) {

		emailService.sendEmail("adiingole1006@gmail.com", "New Enquiry Received ", "Dear Adinath Ingole ,\n\n"
				+ "I hope this email finds you well. \n"
				+ "We have received a new enquiry with the following details: \n\n" + "Enquiry Details: \n\n" + "Name:"
				+ contactList.getName() + "\nEmail : " + contactList.getEmail() + "\nPhone Number: "
				+ contactList.getMobile() + "\nSubject: " + contactList.getServices() + "\nMessage : "
				+ contactList.getMessage()
				+ "\n\nPlease review the enquiry at your earliest convenience and take the necessary actions.\r\n"
				+ "If you need any further information, please let me know. \n\n" + "Thank you. \n "
				+ "\nBest regards, \n" + contactList.getName() + "\n" + contactList.getEmail() + "\n"
				+ contactList.getMobile());

		emailService.sendEmail(contactList.getEmail(), "Thank You for Contacting Kaushalya Infotech : ", "Dear "
				+ contactList.getName()
				+ "\nThank you for choosing Kaushalya Infotech. We have received your enquiry and appreciate you reaching out to us. \r\n\n"
				+ "Our team is currently reviewing your message, and we will get back to you as soon as possible. \r\n"
				+ "If your enquiry is urgent, please feel free to call us at 9049556645.\r\n" + "\r\n"
				+ "In the meantime, if you have any additional information or questions, do not hesitate to reply to this email."
				+ "\r\n" + "Thank you for your patience, and we look forward to assisting you. \r\n\n"
				+ "Best regards,\r\n" + "Adinath Ingole \r\n" + "Software Developer\r\n" + "Kaushalya Infotech\r\n"
				+ "9049556645\r\n" + "Your Website URL");

		System.out.println("Conatct List : " + contactList);

		return contactService.saveContactList(contactList);

	}

	@PostMapping("/save-Chatbot")
	public ResponseEntity<String> saveContact(@RequestBody ContactList contactList) {
		try {
			// Save contact details to the database
			emailService.sendEmail("adiingole1006@gmail.com", "New Enquiry Received From Chatbot. ",
					"Dear Adinath Ingole ,\n\n" + "I hope this email finds you well. \n"
							+ "We have received a new enquiry with the following details: \n\n"
							+ "Enquiry Details: \n\n" + "Name:" + contactList.getName() + "\nEmail : "
							+ contactList.getEmail() + "\nPhone Number: " + contactList.getMobile() + "\nSubject: "
							+ contactList.getServices() + "\nMessage : " + contactList.getMessage()
							+ "\n\nPlease review the enquiry at your earliest convenience and take the necessary actions.\r\n"
							+ "If you need any further information, please let me know. \n\n" + "Thank you. \n "
							+ "\nBest regards, \n" + contactList.getName() + "\n" + contactList.getEmail() + "\n"
							+ contactList.getMobile());

			emailService.sendEmail(contactList.getEmail(), "Thank You for Contacting Kaushalya Infotech : ", "Dear "
					+ contactList.getName()
					+ "\nThank you for choosing Kaushalya Infotech. We have received your enquiry and appreciate you reaching out to us. \r\n\n"
					+ "Our team is currently reviewing your message, and we will get back to you as soon as possible. \r\n"
					+ "If your enquiry is urgent, please feel free to call us at 9049556645.\r\n" + "\r\n"
					+ "In the meantime, if you have any additional information or questions, do not hesitate to reply to this email."
					+ "\r\n" + "Thank you for your patience, and we look forward to assisting you. \r\n\n"
					+ "Best regards,\r\n" + "Adinath Ingole \r\n" + "Software Developer\r\n" + "Kaushalya Infotech\r\n"
					+ "9049556645\r\n" + "Your Website URL");

			contactService.saveContactList(contactList);
			return ResponseEntity.ok("Chat details send successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send chat details.");
		}
	}

}
