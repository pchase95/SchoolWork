<?php
require_once "../Utilities/functions.php";

error_reporting(E_ALL);
ini_set('display_errors', 1);

session_start();
header("Access-Control-Allow-Origin: *");

$cmd = getValue("cmd");
if ($cmd == "sort")
{
  $response = sortValues();
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
          <h2>Sort a list of values in ascending order.</h2>

          <h3>Parameters:</h3>
          <ul>
            <li>cmd=sort</li>
            <li>value[]=n1&amp;value[]=n2&amp;...</li>
          </ul>

          <h3>Returns:</h3>
          <p>The values passed, but in ascending order.</p>

          <h3>Example:</h3>
          <p><a href='sort.php?cmd=sort&value[]=x&value[]=a'>?value[]=x&value[]=a</a></p>
          <pre>
            ['a', 'x']
          </pre>
        </li>
      </ul>
    </body>
  </html>
  ";
}

function sortValues()
{
  // handle command...
  $response = getValue("value");
  sort($response);
  return $response;
}
?>
