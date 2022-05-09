package tec.psl.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] btn = new Button[3][3];
    private LinearLayout llGameBoard;
    private boolean p1Turn;
    private int scoreP1, scoreP2, rounds;
    private boolean winnerIsFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llGameBoard = findViewById(R.id.llGameBoard);
        p1Turn = true;

        createBoard();

    }

    private void createBoard() {
        for(int row = 0; row < 3; row++) {
            LinearLayout ll = new LinearLayout(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            ll.setLayoutParams(lp);
            for(int col = 0; col < 3; col++){
                btn[row][col] = new Button(this);
                LinearLayout.LayoutParams btnP = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1
                );
                btn[row][col].setTextSize(50);
                btn[row][col].setLayoutParams(btnP);
                btn[row][col].setOnClickListener(this);
                ll.addView(btn[row][col]);
            }
            llGameBoard.addView(ll);
        }
    }

    @Override
    public void onClick(View view) {
        if(!((Button) view).getText().equals("")) {
            return;
        }
        if(p1Turn) {
            ((Button) view).setText("X");
        }
        else {
            ((Button) view).setText("O");
        }
        p1Turn = !p1Turn;
    }

    private boolean winnerFound() {
        // TODO skrive kode der finder vinder
        return false;
    }
}