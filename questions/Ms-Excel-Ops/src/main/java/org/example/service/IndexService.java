package org.example.service;

public class IndexService {
    public IndexService() {
    }

    public int[] getIndexFrom(String name) {
        // name can be in the format "A1" or "AA11" -> [0, 0] or [26, 10]
        StringBuilder col = new StringBuilder();
        StringBuilder row = new StringBuilder();
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                row.append(c);
            } else {
                col.append(c);
            }
        }
        int rowIndex = Integer.parseInt(row.toString()) - 1;
        int colIndex = getColumnIndexFromName(col.toString());
        int[] index = new int[2];
        index[0] = rowIndex;
        index[1] = colIndex;
        return index;
    }

    private int getColumnIndexFromName(String columnName) {
        int index = 0;
        for (int i = 0; i < columnName.length(); i++) {
            index = index * 26 + (columnName.charAt(i) - 'A' + 1);
        }
        return index - 1;
    }
}
