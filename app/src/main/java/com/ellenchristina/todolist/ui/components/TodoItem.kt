package com.ellenchristina.todolist.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.Delete
import com.ellenchristina.todolist.domain.Todo
import com.ellenchristina.todolist.domain.todo1
import com.ellenchristina.todolist.domain.todo2
import com.ellenchristina.todolist.ui.theme.ToDoListTheme

@Composable
fun TodoItem(
    todo: Todo,
    onCompletedChange: (Boolean) -> Unit,
    onItemClicked: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface (
        onClick = onItemClicked,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium, // borda de tamanho medio
        shadowElevation = 2.dp,
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline
        )
    ) {
        Row (
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) { // organizado em linhas
            Checkbox(
                checked = todo.isCompleted,
                onCheckedChange = onCompletedChange
            )

            Spacer(modifier = Modifier.width(8.dp)) // espaçamento na horizontal (dentro de row)

            Column (
                modifier = Modifier
                    .weight(1f)
            ) { // organizado em colunas
                Text(
                    text = todo.title,
                    style = MaterialTheme.typography.titleLarge
                )

                todo.description?.let { // exibe apenas se 'description' estiver preenchido
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = todo.description,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp)) // espaçamento na horizontal (dentro de row)

            IconButton (
                onClick = onDeleteClick
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete"
                )
            }
        }
    }
}

@Preview
@Composable
private fun TodoItemPreview() {
    ToDoListTheme {
        TodoItem(
            todo = todo1,
            onCompletedChange = {},
            onItemClicked = {},
            onDeleteClick = {},
        )
    }
}

@Preview
@Composable
private fun TodoItemCompletedPreview() {
    ToDoListTheme {
        TodoItem(
            todo = todo2,
            onCompletedChange = {},
            onItemClicked = {},
            onDeleteClick = {},
        )
    }
}