package omar.cursos.top;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.containerMain)
    CoordinatorLayout containerMain;


    private ArtistaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configToolbar();
        configAdapter();
        configRecyclerView();

        generateArtist();
    }

    private void generateArtist() {

        String[] nombres = {"Rachel", "Mary Elizabeth", "Jessica", "Gal"};
        String[] apellidos = {"McAdams", "Winstead", "Chastain", "Gadot"};
        long[] nacimientos = {280108800000L, 513561600000L, 281491200000L, 483667200000L};
        String[] lugares = {"Canada", "USA", "USA", "Israel"};
        short[] estaturas = {163, 173, 163, 178};
        String[] notas = {"Rachel Anne McAdams was born on November 17, 1978 in London, Ontario, Canada, to Sandra Kay (Gale), a nurse, and Lance Frederick McAdams, a truck driver and furniture mover. She is of English, Welsh, Irish, and Scottish descent. Rachel became involved with acting as a teenager and by the age of 13 was performing in Shakespearean productions in summer theater camp; she went on to graduate with honors with a BFA degree in Theater from York University. After her debut in an tt Jackson (1998), she co-starred in the Canadian TV series Slings and Arrows (20mance in 2003.",
                "Mary Elizabeth Winstead is an actress known for her versatile work in a variety of film and television projects. Possibly most known for her role as Ramona Flowers in Scott Pilgrim contra el mundo (2010), she has also starred in critically acclaimed independent films such as Tocando fondo (2012), for which she received an Independent Spirit Award nomination, as well as genre fare like Destino final 3 (2006) and Quentin Tarantino's Death Proof (2007).",
                "Jessica Michelle Chastain was born in Sacramento, California, and was raised in a middle-class household in a northern California suburb. Her mother, Jerri Chastain, is a vegan chef whose family is originally from Kansas, and her stepfather is a fireman. She discovered dance at the age of nine and was in a dance troupe by age thirteen. She began performing in Shakespearean productions all over the Bay area.",
                "Gal Gadot is an Israeli actress, singer, martial artist, and model. She was born in Rosh Ha'ayin, Israel, to a Jewish family. Her parents are Irit, a teacher, and Michael, an engineer, who is a sixth-generation Israeli. She served in the IDF for two years, and won the Miss Israel title in 2004."};

        String[] fotos = {"https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Rachel_McAdams_3.jpg/751px-Rachel_McAdams_3.jpg",
                "https://m.media-amazon.com/images/M/MV5BNjE3MTU2NjU0OF5BMl5BanBnXkFtZTgwNjgwNzgwNzE@._V1_UY317_CR6,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMTU1MDM5NjczOF5BMl5BanBnXkFtZTcwOTY2MDE4OA@@._V1_UX214_CR0,0,214,317_AL_.jpg",
                "https://m.media-amazon.com/images/M/MV5BMjUzZTJmZDItODRjYS00ZGRhLTg2NWQtOGE0YjJhNWVlMjNjXkEyXkFqcGdeQXVyMTg4NDI0NDM@._V1_UY317_CR51,0,214,317_AL_.jpg"};


        for (int i = 0; i < 4; i++) {
            Artista artista = new Artista(i + 1, nombres[i], apellidos[i], nacimientos[i],
                    lugares[i], estaturas[i], notas[i], i + 1, fotos[i]);

            adapter.add(artista);
        }

    }

    private void configToolbar() {
        setSupportActionBar(toolbar);
    }

    private void configAdapter() {
        adapter = new ArtistaAdapter(new ArrayList<Artista>(), this);
    }

    private void configRecyclerView() {
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /****
     *     Metodos implementados por la interface OnItemClickListener
     ****/

    @Override
    public void onItemClick(Artista artista) {

    }

    @Override
    public void onLongItemClick(Artista artista) {

    }
}
