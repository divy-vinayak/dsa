public class TrappedRainWater {

    public static void WaterTrapped(int height[]){
        // left max 
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1; i < height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        // right max
        int rightMax[] = new int[height.length];
        rightMax[rightMax.length - 1] = height[height.length - 1];
        for(int i = rightMax.length - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int trappedWater = 0;
        for(int i = 1; i < height.length - 1; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }

        System.out.println("Total water trapped: " + trappedWater);
    }
    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        WaterTrapped(height);
    }
}
