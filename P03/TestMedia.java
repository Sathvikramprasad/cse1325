class TestMedia{
    public static void main(String args[]) {
        Media media = new Media("thing to test", "https://www.youtube.com/");
       if(!media.toString().equals("thing to test (https://www.youtube.com/)")){
        System.out.println(media.toString());
        System.exit(1);
       }
    }

}