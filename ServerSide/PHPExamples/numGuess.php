<?php
require_once "../Utilities/functions.php";

error_reporting(E_ALL);
ini_set('display_errors', 1);

session_start();
header("Access-Control-Allow-Origin: *");

$cmd = getValue("cmd");
if ($cmd == "guess")
{
  $response = guess();
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
          <h2>command_name</h2>

          <h3>Parameters:</h3>
          <ul>
            <li>parameter</li>
            <li>parameter</li>
            <li>...</li>
          </ul>

          <h3>Returns:</h3>
          <p>desritpion of return value</p>

          <h3>Example:</h3>
          <p><a href='finename.php?query_string'>query_string</a></p>
          <pre>
            returned json
          </pre>
        </li>
      </ul>
    </body>
  </html>
  ";
}

function guess()
{
  $response = "";
  $mynum = getSessionValue("randnum", -1);
  if ($mynum == -1)
  {
    $mynum = rand(0, 10);
    setSessionValue("randnum", $mynum);
  }

  $yourguess = getValue("num");
  if ($yourguess == $mynum)
  {
    $response = "Correct! Play again";
    setSessionValue("randnum", -1);
  }
  else if ($yourguess < $mynum)
  {
    $response = "Too low, guess again.";
  }
  else
  {
    $response = "Too high, guess again.";
  }

  return $response;
}

?>
