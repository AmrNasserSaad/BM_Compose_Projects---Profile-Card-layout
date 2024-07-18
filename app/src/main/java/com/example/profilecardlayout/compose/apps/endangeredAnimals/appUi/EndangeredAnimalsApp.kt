import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.profilecardlayout.R
import com.example.profilecardlayout.compose.apps.endangeredAnimals.data.DataSource
import com.example.profilecardlayout.compose.apps.endangeredAnimals.model.Animal
import com.example.profilecardlayout.ui.theme.CatskillWhite


@Composable
fun AnimalsList(animals: List<Animal>) {
    LazyColumn {
        items(animals) {
            AnimalListItem(animal = it)
        }
    }
}

@Composable
fun AnimalListItem(animal: Animal, modifier: Modifier = Modifier) {
    // State Hosting
    var isDialogShown by remember { mutableStateOf(false) }
    if (isDialogShown) {
        AnimalHelperDialog(animal = animal) {
            isDialogShown = it
        }
    }

    Card(
        colors = CardDefaults.cardColors(containerColor = CatskillWhite),
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = animal.picture),
                contentDescription = stringResource(
                    id = animal.name
                ),
                modifier = modifier.size(120.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .height(120.dp)
                    .fillMaxWidth()

            ) {
                Text(
                    text = stringResource(id = animal.name),
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .weight(1f)
                        .wrapContentHeight()
                )
                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(
                                text = stringResource(
                                    id = R.string.save_the_animal,
                                    stringResource(id = R.string.save), "", ""
                                )
                            )
                        }
                        append(
                            stringResource(
                                id = R.string.save_the_animal,
                                "",
                                stringResource(id = R.string.the_animal),
                                ""
                            )
                        )
                    },
                    modifier = modifier.clickable {
                        isDialogShown = true
                    }
                )
            }
        }
    }

}

@Composable
fun AnimalHelperDialog(animal: Animal, onShowDialogChange: (Boolean) -> Unit) {

    val context = LocalContext.current
    AlertDialog(
        onDismissRequest = { },
        confirmButton = {
            TextButton(onClick = {
                onShowDialogChange(false)
                val i = Intent(Intent.ACTION_VIEW, animal.link.toUri())
                context.startActivity(i)
            }) {
                Text(text = stringResource(id = R.string.proceed))
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onShowDialogChange(false)
            }) {
                Text(text = stringResource(id = R.string.cancel))
            }
        },
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_help_outline_24),
                contentDescription = stringResource(id = R.string.help)
            )
        },
        title = {
            Text(
                text = stringResource(
                    id = R.string.save_the_animal,
                    stringResource(id = R.string.save),
                    stringResource(id = R.string.the_animal),
                    " ?"
                )
            )
        },
        text = {
            Text(text = stringResource(id = animal.description))
        }

    )
}

@Preview(showBackground = true)
@Composable
fun AnimalListItemPreview() {
    AnimalsList(animals = DataSource().getAnimalsData())
}