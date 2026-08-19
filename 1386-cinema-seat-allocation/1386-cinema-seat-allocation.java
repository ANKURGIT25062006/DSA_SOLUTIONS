class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        for (int[] seat : reservedSeats) {
            rowMap.computeIfAbsent(seat[0], k -> new HashSet<>()).add(seat[1]);
        }

        long result = (long) (n - rowMap.size()) * 2;

        for (Set<Integer> seats : rowMap.values()) {
            boolean canLeft = isFree(seats, 2, 5);
            boolean canMid = isFree(seats, 4, 7);
            boolean canRight = isFree(seats, 6, 9);

            if (canLeft && canRight) {
                result += 2;
            } else if (canLeft || canMid || canRight) {
                result += 1;
            }
        }

        return (int) result;
    }

    private boolean isFree(Set<Integer> seats, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (seats.contains(i)) return false;
        }
        return true;
    }
}