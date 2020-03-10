public class Box {
    int height;
    int width;
    int depth;



    Box(int height,int width , int depth){
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
    public void volume(){
        int volume = height*width*depth;
        System.out.println("The volume of the box is : " +volume);
    }
}
