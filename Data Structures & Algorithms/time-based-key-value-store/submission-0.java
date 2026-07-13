class keyvault {
    String value;
    int time;
    public keyvault(String value, int time){
        this.value = value;
        this.time = time;
    }
}
class TimeMap {
    HashMap<String,List<keyvault>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyvault k = new keyvault(value,timestamp);
        if(map.containsKey(key)){
            map.get(key).add(k);
        }
        else {
            List<keyvault> li = new ArrayList<>();
            li.add(k);
            map.put(key,li);
        }
    }
    
    public String get(String key, int timestamp) {
        List<keyvault> list = map.get(key);
        if(list == null){
            return "";
        }
        int l =0, r = list.size() -1 ;
        String res = "";
        while(l <= r){
            int mid = (l+r)/2;
            if(list.get(mid).time <= timestamp ){
                res = list.get(mid).value;
                l = mid + 1;
            }
            else {
                r = mid -1 ;
            }
        }

        return res;
    }
}
