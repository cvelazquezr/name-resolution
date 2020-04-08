bw.write(Strings.padEnd(firstName, maxSize, ' '));
  for(int i=0;i<20;++i) bw.write(' ');
  //You need to pad the end here of course again like in the first row; 
  bw.write(secondName);
  bw.newLine();
  bw.write(Strings.padEnd(school, maxSize, ' '));
  for(int i=0;i<20;++i) bw.write(' ');
  //You need to pad the end here of course again like in the first row; 
  bw.write(yob);
