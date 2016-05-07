<?php

echo prob1();
echo prob2();

function prob1()
{
  $r = 0;
  for ($i = 0; $i < 8; $i++)
  {
    $r = $r + $i;
  }
  return $r;
}

function prob2()
{
  $r = 0;
  $x = [1, 4, 9, 3];
  for ($i = 0; $i < count($x); $i++)
  {
    $r = $r + $x[$i];
  }
  return $r;
}
?>
