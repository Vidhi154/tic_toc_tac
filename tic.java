class tic_toc{
    protected final int X=1;
    protected final int O =-1;
    protected final int empty = 0;
    int player;
    protected int[][] board = new int[3][3];
    tic_toc(){
        clearboard();
        System.out.println("first player will have " + player);
        System.out.println("X = " + X + "\n" + "O = " + O);
        System.out.println(this.toString());
    }

    void clearboard(){
        for(int i =0;i<3;i++){
            for(int j = 0;j<3;j++){
                board[i][j]=empty;
            }
        }
        //current player
        player=X;
    }

    public void putmark(int i  ,int j) throws IllegalArgumentException{
        if(i<0 || i>2 || j<0 || j>2){
            throw new IllegalArgumentException("not vaild position");
        }
        if(board[i][j]!=empty){
            throw new IllegalArgumentException("not free space");
        }
        board[i][j]= player;
        System.out.println(this.toString());
        player= - player;
        System.out.println("current palyer " + player);
    }

    public boolean iswin(int mark){
        return ((board[0][0] + board[0][1] + board[0][2] == mark*3) || (board[1][0] + board[1][1] + board[1][2] == mark*3) ||
                (board[2][0] + board[2][1] + board[2][2] == mark*3) || (board[0][0] + board[1][0] + board[2][0] == mark*3)
                || (board[0][1] + board[1][1] + board[2][1] == mark*3) || (board[0][2] + board[1][2] + board[2][2] == mark*3)
                || (board[0][0] + board[1][1] + board[2][2] == mark*3) || (board[0][2] + board[1][1] + board[2][0] == mark*3));
    }

    public void whowin(){
        if(iswin(X)){
            System.out.println("X is the winner");
        } else if (iswin(O)) {
            System.out.println("O is the winner");
        }
        else
            System.out.println("there is a tie");
    }

    public String toString(){
        System.out.println("------ tic toc tac game -----");
        StringBuilder s = new StringBuilder();
        for(int i =0;i<3;i++){
            for(int j =0;j<3;j++){
                switch (board[i][j]){
                    case X : s.append("X");
                        break;
                    case O: s.append("O");
                        break;
                    case empty : s.append(" ");
                        break;
                }
                if(j<2){
                    s.append("|");
                }

            }

            if(i<2){
                s.append("\n-----\n");
            }

        }
        return s.toString();

    }



}

public class tic {
    public static void main(String[] args) {
        tic_toc game = new tic_toc();
        try {
//            System.out.println(game.toString());
            game.putmark(1, 0);
            System.out.println();
//            System.out.println(game.toString());
            System.out.println();
            game.putmark(0, 0);
//            System.out.println(game.toString());
            game.putmark(2, 0);
//            System.out.println(game.toString());
            game.putmark(2,2);
//            System.out.println(game.toString());
            game.putmark(1,2);
//            System.out.println(game.toString());
            game.putmark(2,1);
//            System.out.println(game.toString());
            game.putmark(1,1);
//            System.out.println(game.toString());

        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
        game.whowin();
    }
}
