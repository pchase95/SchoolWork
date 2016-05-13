fw = open('secrets.txt', 'w')
fw.write('i hate jews so much :(\n')
fw.write('niggers annoy me too')
fw.close()

fr = open('secrets.txt', 'r')
text = fr.read()
fr.close()

print text
