class UndergroundSystem {
    private Map<Integer, Pair> checkIns;
    private Map<String, double[]> travelStats;
    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelStats = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Pair(stationName, t));
    }
    public void checkOut(int id, String stationName, int t) {
        Pair checkInInfo = checkIns.remove(id);
        String startStation = checkInInfo.station;
        int startTime = checkInInfo.time;
        String key = startStation + "->" + stationName;
        travelStats.putIfAbsent(key, new double[]{0, 0});
        double[] stats = travelStats.get(key);
        stats[0] += (t - startTime); 
        stats[1] += 1;               
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;
        double[] stats = travelStats.get(key);
        return stats[0] / stats[1];
    }
    private static class Pair {
        String station;
        int time;
        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}
