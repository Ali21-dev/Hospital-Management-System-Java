# Hospital Management System – Java Laboratory Experiments

A collection of 15 standalone Java programs based on the supplied Hospital Management System Java laboratory record. Each experiment is kept in its own folder so classes with repeated names do not conflict.

## Requirements
- JDK 8 or later

## Experiments

1. **Classes, Objects, Constructors, and Methods** — `experiment-01-classes-objects-constructors-methods/`
2. **Static and Non-static Members, Access Modifiers, Abstraction, and Encapsulation** — `experiment-02-static-access-abstraction-encapsulation/`
3. **Scanner and System Classes for Console Input and Output** — `experiment-03-scanner-console-input-output/`
4. **Hierarchical and Multilevel Inheritance** — `experiment-04-inheritance/`
5. **Method Overloading and Method Overriding** — `experiment-05-polymorphism/`
6. **Abstract Classes, Interfaces, and Dynamic Method Dispatch** — `experiment-06-abstract-classes-interfaces/`
7. **Built-in and User-defined Packages** — `experiment-07-java-packages/`
8. **Built-in and User-defined Exceptions** — `experiment-08-exception-handling/`
9. **Thread Class and Runnable Interface** — `experiment-09-multithreading/`
10. **Synchronization and Inter-thread Communication** — `experiment-10-synchronization-wait-notify/`
11. **Thread Lifecycle and Deadlock Prevention** — `experiment-11-thread-lifecycle-deadlock-prevention/`
12. **List, Set, Map, and Queue Interfaces** — `experiment-12-collections-framework/`
13. **Comparable and Comparator Sorting** — `experiment-13-comparable-comparator/`
14. **Java I/O Streams, Readers, Writers, and Buffered Streams** — `experiment-14-java-file-io/`
15. **Serialization and Deserialization** — `experiment-15-serialization/`

## Run an experiment
1. Open a terminal in the folder for the experiment you want to run.
2. Follow the compile and run commands in that folder’s `README.md`.
3. For Experiment 7, run the commands from the experiment folder so the `hospital` package path is resolved.

## Notes
- These are independent lab exercises, not one combined production hospital application.
- Experiments 14 and 15 create sample data files when run; those generated files are excluded from Git by `.gitignore`.
- Sample patient details are illustrative test data from the lab exercises.

## Upload to GitHub
Create a new repository on GitHub, then from this project folder run:
```bash
git init
git add .
git commit -m "Add Hospital Management System Java experiments"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/YOUR-REPOSITORY.git
git push -u origin main
```
Replace the remote URL with your repository URL.
