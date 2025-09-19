class Spreadsheet {
    int sheet[][];
    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        char col = cell.charAt(0);
        int row = Integer.parseInt(cell.substring(1));
        sheet[row - 1][col - 'A'] = value;
    }

    public void resetCell(String cell) {
        char col = cell.charAt(0);
        int row = Integer.parseInt(cell.substring(1));
        sheet[row - 1][col - 'A'] = 0;
    }
    
    public int getValue(String form) {
        String sub = form.substring(1);
        String part[] = sub.split("\\+");
        int sum = 0;
        if(Character.isLetter(part[0].charAt(0))){
            int col = part[0].charAt(0) - 'A';
            int row = Integer.parseInt(part[0].substring(1));
            sum += sheet[row-1][col];
        }else{
            sum += Integer.parseInt(part[0]);
        }

        if(Character.isLetter(part[1].charAt(0))){
            int col = part[1].charAt(0) - 'A';
            int row = Integer.parseInt(part[1].substring(1));
            sum += sheet[row-1][col];
        }else{
            sum += Integer.parseInt(part[1]);
        }
        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */