# Perceptron

A Java implementation of a binary perceptron. The repository includes a console application and two versions with a Swing graphical interface.

## Features

- A perceptron with weights, a decision threshold and learning parameters `alpha` and `beta`.
- Training on data loaded from a file.
- Accuracy evaluation on a test dataset.
- Reading datasets from `.data` files.
- Supporting linear algebra operations.
- A console version with interactive parameter input.
- A GUI version with fields for dataset filenames, learning parameters and the number of epochs.
- A GUI variant with an additional target class field.

## Tech Stack

- Java
- Java Swing
- Java standard library
- IntelliJ IDEA project structure (`.iml` files)

## Getting Started

Requirements:

- A JDK
- A Java development environment, such as IntelliJ IDEA, or command-line compilation tools

Before running a version, update its hardcoded dataset path in `ReadData.java` as described in the Data section below. Each command block starts from the repository root.

Console version:

```bash
cd mpp2/src
javac *.java
java Main
```

GUI version:

```bash
cd mpp2_gui/src
javac *.java
java Main
```

GUI variant for Iris data:

```bash
cd mpp2_gui_iris/src
javac *.java
java Main
```

## Data

The repository includes the following datasets:

```text
perceptron.data
perceptron.test.data
```

The current implementation of `ReadData.java` uses this hardcoded local directory:

```text
/Users/karo/Desktop/Ćwiczenia 2 - Perceptron/
```

Change this path to the directory containing your dataset files, or place the files at the expected location.

## Project Structure

```text
Perceptron/
├── mpp2/               # Console version
├── mpp2_gui/           # Swing GUI version
├── mpp2_gui_iris/      # GUI variant with a target class field
├── perceptron.data
└── perceptron.test.data
```

## Notes

The project does not use external libraries. Automated tests are not included.
