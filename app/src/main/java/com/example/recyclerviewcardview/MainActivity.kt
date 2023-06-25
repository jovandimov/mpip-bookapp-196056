package com.example.recyclerviewcardview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewcardview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BookClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CardAdapter

    private fun setupRecyclerView() {
        adapter = CardAdapter(bookList, this)
        // ...
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateBooks()
        setupRecyclerView()

        val mainActivity = this
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
//            adapter = CardAdapter(bookList, mainActivity)
            adapter = this@MainActivity.adapter
        }

        binding.btnAddBook.setOnClickListener {
            val intent = Intent(this, AddBookActivity::class.java)
            startActivityForResult(intent, 1)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val newBook = data?.getSerializableExtra("newBook") as? Book
            if (newBook != null) {
                bookList.add(newBook)
                adapter.updateData(bookList)
            }
        }
    }


    override fun onClick(book: Book) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra(BOOK_ID_EXTRA, book.id)
        startActivity(intent)
    }


    private fun populateBooks() {
        val book1 = Book(
            "Marcel Proust",
            "In Search of Lost Time",
            "Swann's Way, the first part of A la recherche de temps perdu, Marcel Proust's seven-part cycle, was published in 1913. In it, Proust introduces the themes that run through the entire work. The narrator recalls his childhood, aided by the famous madeleine; and describes M. Swann's passion for Odette. The work is incomparable. Edmund Wilson said \"[Proust] has supplied for the first time in literature an equivalent in the full scale for the new theory of modern physics.\"",
            "https://d3i5mgdwi2ze58.cloudfront.net/ohbd3xqukj7do2f0o5txmhghfsva"
        )

        bookList.add(book1)

        val book2 = Book(
            "James Joyce\n",
            "Ulysses",
            "Ulysses chronicles the passage of Leopold Bloom through Dublin during an ordinary day, June 16, 1904. The title parallels and alludes to Odysseus (Latinised into Ulysses), the hero of Homer's Odyssey (e.g., the correspondences between Leopold Bloom and Odysseus, Molly Bloom and Penelope, and Stephen Dedalus and Telemachus). Joyce fans worldwide now celebrate June 16 as Bloomsday.",
            "https://d3i5mgdwi2ze58.cloudfront.net/usuab7s8yuwlcmadwx9woy746lvi"
        )

        bookList.add(book2)


        val book3 = Book(
            "Miguel de Cervantes",
            "Don Quixote",
            "Alonso Quixano, a retired country gentleman in his fifties, lives in an unnamed section of La Mancha with his niece and a housekeeper. He has become obsessed with books of chivalry, and believes their every word to be true, despite the fact that many of the events in them are clearly impossible. Quixano eventually appears to other people to have lost his mind from little sleep and food and because of so much reading.",
            "https://d3i5mgdwi2ze58.cloudfront.net/zneklbeomp32h7fsp1isfkifhxrv"
        )

        bookList.add(book3)

        val book4 = Book(
            "Gabriel Garcia Marquez",
            "One Hundred Years of Solitude",
            "One of the 20th century's enduring works, One Hundred Years of Solitude is a widely beloved and acclaimed novel known throughout the world, and the ultimate achievement in a Nobel Prize–winning career. The novel tells the story of the rise and fall of the mythical town of Macondo through the history of the Buendía family. It is a rich and brilliant chronicle of life and death, and the tragicomedy of humankind. In the noble, ridiculous, beautiful, and tawdry story of the Buendía family, one sees all of humanity, just as in the history, myths, growth, and decay of Macondo, one sees all of Latin America. Love and lust, war and revolution, riches and poverty, youth and senility — the variety of life, the endlessness of death, the search for peace and truth — these universal themes dominate the novel. Whether he is describing an affair of passion or the voracity of capitalism and the corruption of government, Gabriel García Márquez always writes with the simplicity, ease, andpurity that are the mark of a master. Alternately reverential and comical, One Hundred Years of Solitude weaves the political, personal, and spiritual to bring a new consciousness to storytelling. Translated into dozens of languages, this stunning work is no less than an accounting of the history of the human race.",
            "https://d3i5mgdwi2ze58.cloudfront.net/7pc7v940tg2z40i9x9tq7qi0fx35"
        )

        bookList.add(book4)

        val book5 = Book(
            "F. Scott Fitzgerald",
            "The Great Gatsby",
            "The novel chronicles an era that Fitzgerald himself dubbed the \"Jazz Age\". Following the shock and chaos of World War I, American society enjoyed unprecedented levels of prosperity during the \"roaring\" 1920s as the economy soared. At the same time, Prohibition, the ban on the sale and manufacture of alcohol as mandated by the Eighteenth Amendment, made millionaires out of bootleggers and led to an increase in organized crime, for example the Jewish mafia. Although Fitzgerald, like Nick Carraway in his novel, idolized the riches and glamor of the age, he was uncomfortable with the unrestrained materialism and the lack of morality that went with it, a kind of decadence.",
            "https://d3i5mgdwi2ze58.cloudfront.net/z3d1ro97lc1yd91yalvalbn2xcc5"
        )

        bookList.add(book5)
    }

    fun launchAddBookActivity(view: View) {}
}