GridBagConstraints constraints = new GridBagConstraints();
JPanel jPanel1 = new JPanel(new GridBagLayout());
constraints.fill = GridBagConstraints.HORIZONTAL;
jPanel1.add(jPanel2, constraints);
constraints.gridy ++;
jPanel1.add(jPanel2, constraints);
