<?php
include 'library.php'; // include the library file
include "classes/class.phpmailer.php"; // include the class name
if(isset($_POST["send"])){
	$email = $_POST["email"];
	$mail	= new PHPMailer; // call the class 
	$mail->IsSMTP(); 
	$mail->Host = SMTP_HOST; //Hostname of the mail server
	$mail->Port = SMTP_PORT; //Port of the SMTP like to be 25, 80, 465 or 587
	$mail->SMTPAuth = true; //Whether to use SMTP authentication
	$mail->Username = SMTP_UNAME; //Username for SMTP authentication any valid email created in your domain
	$mail->Password = SMTP_PWORD; //Password for SMTP authentication
	$mail->AddReplyTo("reply@ecf.org.in", "Reply name"); //reply-to address
	$mail->SetFrom("admin@ecf.org.in", "ECF"); //From address of the mail
	// put your while loop here like below,
	$mail->Subject = "Your ECF Donation Reminder"; //Subject od your mail
	$mail->AddAddress($email, "ECF"); //To address who will receive this email
	$mail->MsgHTML("<b>Thank You For Your Donation.Your Donation is valuable for poor Students of our country.
	Regards,   <br/><br/>by <a href=http://www.ecf.org.in'>ECF-(Equal Community Foundation)</a></b>"); //Put your body of the message you can place html code here
	$mail->AddAttachment("email-pic/11.gif"); //Attach a file here if any or comment this line, 
	$send = $mail->Send(); //Send the mails
	if($send){
		echo '<center><h3>Thank You</h3></center>';
	}
	else{
		echo '<center><h3 style="color:#FF3300;">Mail error: </h3></center>'.$mail->ErrorInfo;
	}
}
?>
<!DOCTYPE html>
<html>

<body><?php include "gmailheader.html";
?>
<br>
<div class="as_wrapper">
	<h5 class="tw_bullet">Please Enter Your Email Address For Confirmation</h5>
    <form action="" method="post">
    <table class="mytable">
    <tr>
    	<td><input type="email" placeholder="Email" name="email" /></td>
	</tr>
    <tr>
    	<td><input type="submit" name="send" value="Submit" /></td>
	</tr>
    </table>
    </form>
</div>
<?php
include "foot.html";
?>
</body>
</html>
