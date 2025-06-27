#  Java Notepad App

A simple **console-based Notepad application** built using Java. It lets you create, write, read, update, and delete text notes — all through your terminal. Perfect for beginners looking to practice Java file handling and get comfortable with basic input/output operations.

---

##  Project Overview

This project provides a command-line interface to manage `.txt` notes. It’s made using core Java libraries, especially `java.io` for file operations and `java.util.Scanner` for user input.

---

##  Features

-  Create a new note (as a `.txt` file)
-  Write content into a note (overwrites existing text)
-  Read a note
-  Update a note (append new content)
-  Clear content of a note (without deleting the file)
-  Delete a note (permanently removes the file)
-  Exit the program anytime

---

##  Methods Breakdown

### `createNote(Scanner sc)`
Creates a new file based on user input. If it already exists, shows a message.

### `writeNote(Scanner sc)`
Writes (overwrites) content in the specified file.

### `readNote(Scanner sc)`
Reads and prints content from the selected note file.

### `updateNote(Scanner sc)`
Appends content to an existing note.

### `deleteNoteContent(Scanner sc)`
Erases all content inside the note without deleting the file.

### `deleteNote(Scanner sc)`
Deletes the entire note file from the directory.

---

##  Example Usage

```bash
$ java NotePadApp
Hello, welcome to Notepad

Enter the number for the operation you want to perform:
1 - Create a new note
2 - Write to a note
3 - Read a note
4 - Update a note
5 - Clear note content
6 - Delete a note
7 - Exit

Enter the number: 1
Enter name for the file:
> myNotes

New file created with name myNotes.txt
