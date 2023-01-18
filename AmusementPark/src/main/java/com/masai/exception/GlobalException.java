package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
   
	 @ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<MyErrorDetails> methodValidationHandler(MethodArgumentNotValidException m){
			   MyErrorDetails err= new MyErrorDetails();
			      err.setTimestamp(LocalDateTime.now());
			      err.setMessege("validation error");
			      err.setDecsription(m.getBindingResult().getFieldError().getDefaultMessage());
			      return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		}
		@ExceptionHandler(CustomerException.class)
		public ResponseEntity<MyErrorDetails> methodCustomerException(CustomerException st,WebRequest req){
			 MyErrorDetails err= new MyErrorDetails();
		      err.setTimestamp(LocalDateTime.now());
		      err.setMessege(st.getMessage());
		      err.setDecsription(req.getDescription(false));
		      return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		}
		@ExceptionHandler(ActivityException.class)
		public ResponseEntity<MyErrorDetails> methodActivityException(ActivityException st,WebRequest req){
			 MyErrorDetails err= new MyErrorDetails();
		      err.setTimestamp(LocalDateTime.now());
		      err.setMessege(st.getMessage());
		      err.setDecsription(req.getDescription(false));
		      return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		}
		@ExceptionHandler(AdminException.class)
		public ResponseEntity<MyErrorDetails> methodAdminException(AdminException st,WebRequest req){
			 MyErrorDetails err= new MyErrorDetails();
		      err.setTimestamp(LocalDateTime.now());
		      err.setMessege(st.getMessage());
		      err.setDecsription(req.getDescription(false));
		      return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		}
		@ExceptionHandler(Exception.class)
		public ResponseEntity<MyErrorDetails> methodException(Exception st,WebRequest req){
			 MyErrorDetails err= new MyErrorDetails();
		      err.setTimestamp(LocalDateTime.now());
		      err.setMessege(st.getMessage());
		      err.setDecsription(req.getDescription(false));
		      return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		}
}
