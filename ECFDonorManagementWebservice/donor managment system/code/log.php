 <?php
session_start();
$host="localhost";
$user="root";
$pass="root";
$con = mysql_connect("$host","$user","$pass");


if (!$con)
  {

echo "Error in DBConnect() = " . mssql_get_last_message();
  die('Could not connect: ' . mysql_error());

  }
mysql_select_db("ecf", $con);
$myusername=$_POST['name'];
$mypassword=$_POST['password'];



 $mysql = "SELECT * FROM admin WHERE name='$myusername' and password='$mypassword'";

 $result = mysql_query($mysql) or die("cannot execute query");

 $count = mysql_num_rows($result);
$row = mysql_fetch_array($result);
  
  $_SESSION['s_id'] = $row['id'];
 if($count==1)
 {
 //session_register('username');
	header("location:admin_page.php"); // put your home page neme here
}

 else
	header("location:login.php");

 ?>
