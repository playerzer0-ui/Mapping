

public class Map {

    private Entry[] data;
    private int size;

    public Map(){
        data = new Entry[20];
        size = 0;
    }

    private int hash(String key){
        return Math.abs(key.hashCode()) % data.length;
    }

    public boolean put(String key, String value){
        if(key == null || value == null){
            throw new IllegalArgumentException();
        }
        int slot = hash(key);
        Entry newEntry = new Entry(key, value);

        if(data[slot] == null){
            data[slot] = newEntry;
            size++;
        }
        else{
            if(hash(data[slot].key) == slot){
                data[slot].value = value;
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    public String get(String key){
        if(key == null){
            throw new IllegalArgumentException();
        }
        int slot = hash(key);
        if(data[slot] == null){
            return null;
        }
        else{
            return data[slot].value;
        }
    }

    @Override
    public String toString() {
        String out = "{";
        int index = 0;
        boolean flag = false;

        for(int i = 0; i < data.length; i++){
            if(data[i] != null){
                out += data[i].key + "=" + data[i].value;
                index++;
                if(index != size && !flag){
                    out += ", ";
                }
                else{
                    out += "}";
                }
            }
        }
        return out;
    }

    private static class Entry {
        private String key;
        private String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

}
