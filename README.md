# Library Kata

## Scenario
The town library lends books and prints reminder letters for the overdue ones.
It's legacy code, and you're asked to write unit tests for it.

Follow the comments, make the tests pass

## Exercise 1 — Test it with Mockito
file: `_1_MockedLoanTest` (`legacy` folder)
(timebox to 5 minutes)

## Exercise 2 — Test it with a Nullable
You now have nullables that were created for you (`refactored` folder).
Use them instead of mockito

file: `_2_1_NullLoanTest`
file: `_2_2_NullLoanTest`
file: `_2_3_NullLoanTest`

## Exercise 3 — Make Library Nullable
`Library` needs a database, a printer, and the wall clock.
Its dependencies are already Nullables — give `Library` its own `createNull()`.

file: `_3_1_LibraryTest`

## Exercise 4 — Control and Observe your World
Tell the Library what books are borrowed and check what reminders it prints. 

file: `_4_1_LibraryTest`
file: `_4_2_LibraryTest`

---

## Running the tests

Java 17+ 

`./test.sh` (Windows: `test.cmd`).

---

## References

- [Testing Without Mocks: Nullables](https://www.jamesshore.com/v2/projects/nullables) — James Shore
