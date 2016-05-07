<?php
require_once "../Utilities/functions.php";

error_reporting(E_ALL);
ini_set('display_errors', 1);

session_start();
header("Access-Control-Allow-Origin: *");

$cmd = getValue("cmd");
if ($cmd == "addColor")
{
  $response = addColor();
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

function addColor()
{
  $response = getSessionValue("listOfColors", []);

  $color = getValue("color");
  $response[] = $color;

  setSessionValue("listOfColors", $response);

  return $response;
}

?>
