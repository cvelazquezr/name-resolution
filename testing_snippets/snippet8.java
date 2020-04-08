Handler mHandler = new Handler() {
    public void handleMessage( Message msg ) 
    {  
        Toast toast;
            switch(msg.what) 
            {          
               case 1: // for success
                   toast = Toast.makeText(getBaseContext(), "File has been successfully written.", Toast.LENGTH_LONG);
                   toast.show();
               break;
               case 0: // for Error
                   toast = Toast.makeText(getBaseContext(), "Error occur during writting file.", Toast.LENGTH_LONG);
                   toast.show();
               break:

           }
   }
