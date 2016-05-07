<?php
require_once "../Utilities/functions.php";

error_reporting(E_ALL);
ini_set('display_errors', 1);

session_start();
header("Access-Control-Allow-Origin: *");

$cmd = getValue("cmd");
if ($cmd == "hello")
{
  $response = sayHello();
  header('Content-type: application/json');
  echo json_encode($response);
}
else if ($cmd == "time")
{
  $response = getTime();
  header('Content-type: application/json');
  echo json_encode($response);
}
else // list all supported commands
{
  echo
  "
  <html>
    <body>
      <h1>API</h1>
      <ul>
        <li>
          <h2>Say hello to me</h2>

          <h3>Parameters:</h3>
          <ul>
            <li>cmd=hello</li>
          </ul>

          <h3>Returns:</h3>
          <p>A hello message</p>

          <h3>Example:</h3>
          <p><a href='hello.php?cmd=hello'>cmd=hello</a></p>
          <pre>
            Hello it is nice to meet you.
          </pre>
        </li>
        <li>
          <h2>Get the time</h2>

          <h3>Parameters:</h3>
          <ul>
            <li>cmd=time</li>
          </ul>

          <h3>Returns:</h3>
          <p>The current time of day</p>

          <h3>Example:</h3>
          <p><a href='hello.php?cmd=time'>cmd=time</a></p>
          <pre>
            12:15:32
          </pre>
        </li>
      </ul>
    </body>
  </html>
  ";
}

function sayHello()
{
  $response = "Hello it is nice to meet you.";
  return $response;
}

function getTime()
{
  $response = date("h:i:sa");
  return $response;
}

?>
