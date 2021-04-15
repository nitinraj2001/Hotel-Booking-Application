package com.nitinraj.hotelbooking.controller;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nitinraj.hotelbooking.Service.BookingDetailService;
import com.nitinraj.hotelbooking.Service.CustomUserDetails;
import com.nitinraj.hotelbooking.Service.RoomService;
import com.nitinraj.hotelbooking.Service.UserService;
import com.nitinraj.hotelbooking.model.BookingDetail;
import com.nitinraj.hotelbooking.model.Room;
import com.nitinraj.hotelbooking.model.Users;
import com.nitinraj.hotelbooking.utility.ImageUtil;

@Controller
@RequestMapping("/user")
@MultipartConfig
public class UserController {
	
	private UserService theUserService;
	
	@Autowired
	private RoomService theRoomService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private ImageUtil theImageUtil;
	
	@Autowired
	private BookingDetailService theBookingDetailService;
	
	
	@Autowired
	public UserController(UserService userService) {
		theUserService=userService;
	}
	
	
    
	@PostMapping(value="/Save")
	public String saveUser(@ModelAttribute("user") Users theUser, @RequestParam("img") MultipartFile img) {
		
		
		theUser.setEnabled(true);
		
		try {
			
			theUser.getUserprofile().setUserImage(img.getBytes());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		theUser.getUserprofile().setUserRole("USER");
		String password=theUser.getPassword();
		String encryptPassword=passwordEncoder.encode(password);
		theUser.setPassword(encryptPassword);
		
		System.out.println(theUser);
		
		
		theUserService.save(theUser);
		
		return "redirect:/login";
	}
	
	@PreAuthorize("hasAnyRole('USER')")
	@PostMapping("/functionality")
	public String redirectFunPage() {
		return "user successfully login to his/her Functionality";
		
	}
	
	@GetMapping("/functionality")
	public String redirect() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		CustomUserDetails userdetails= (CustomUserDetails) auth.getPrincipal();
		
		String username=userdetails.getUsername();
		
		
		
		Users theUser=theUserService.findUser(username);
		if(theUser.getUserprofile().getUserRole().equalsIgnoreCase("ADMIN")) {
			return "admin-dashboard";
		}
		
		return "userAdministration";
		
	}
	
	@GetMapping("/admin")
	public String admindashboard() {
		return "admin-dashboard";
	}
	
	@GetMapping("/admin/customer")
	public String customerReports(Model theModel) {
		List<Users> userslist=theUserService.FindAllUsers();
		theModel.addAttribute("users", userslist);
		theImageUtil=new ImageUtil();
		
		theModel.addAttribute("image", theImageUtil);
		return "customer-report";
	}
	
	@GetMapping("/admin/addroom")
	public String addroom(Model themodel) {
		Room theRoom=new Room();
		themodel.addAttribute("room", theRoom);
		return "add-room";
	}
	
	@PostMapping("/admin/saveroom")
	public String saveMyRoom(@ModelAttribute("room") Room theRoom, @RequestParam("Image") MultipartFile Image) {
		try {
			theRoom.setRoomImage(Image.getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		theRoom.setBookedStatus(false);
		
		theRoomService.saveRoom(theRoom);
		
		System.out.println(theRoom);
		return "room-add-success-page";
	}
	
	@GetMapping("/getavailablerooms")
	public String availableroomsfetch(Model theModel) {
		List<Room> theRooms=theRoomService.getAvailableRooms();
		theModel.addAttribute("rooms", theRooms);
        theImageUtil=new ImageUtil();
		
		theModel.addAttribute("image", theImageUtil);
		
		return "list-available-rooms";
	}
	
	@GetMapping("/showFormForBooking")
	public String showFormForBooking(Model themodel) {
		BookingDetail bookdetail=new BookingDetail();
		themodel.addAttribute("bookingdetail",bookdetail );
		return "room-booking-form";
	}
	
	@PostMapping("/book/room")
	public String bookroom(@ModelAttribute("bookingdetail") BookingDetail theBookingDetail) {
		theBookingDetail.setCheckInTime(LocalTime.now().toString());
		System.out.println(theBookingDetail);
		
		int RoomNo=theBookingDetail.getBookedRoomNo();
        
		Room theRoom=theRoomService.getRoom(RoomNo);
		
		theRoom.setBookedStatus(true);
		
		theRoomService.saveRoom(theRoom);
	
		
		theBookingDetailService.savebookingdetail(theBookingDetail);
		
		return "booking-confirm-detail-page";
		
	}
}
