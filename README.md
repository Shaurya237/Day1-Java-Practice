# Day 1 Live-Coding Session — Java Solutions

This folder contains five standalone Java programs for the Day 1 practice problems.

## Requirements
- Java JDK 17 or later (tested with JDK 21)
- A terminal or Java IDE

## Programs and how to run
Run these commands from this directory. Compile and run one program at a time:

```bash
javac RockPaperScissors.java && java RockPaperScissors
javac PalindromeChecker.java && java PalindromeChecker
javac TeamBmiCalculator.java && java TeamBmiCalculator
javac FirstNonRepeatingCharacter.java && java FirstNonRepeatingCharacter
javac ReverseCustomerName.java && java ReverseCustomerName
```

## Notes
1. **RockPaperScissors** — plays a user-selected number of rounds, generates the computer's move randomly, stores each round in arrays, and prints a scoreboard and win percentage.
2. **PalindromeChecker** — checks the exact input text using iterative, recursive, and array-reversal approaches. Spaces and letter case are treated as characters, so `Madam` and `madam` are different inputs for this implementation.
3. **TeamBmiCalculator** — collects height and weight for 10 people, computes BMI, and prints a wellness report. Use metres for height and kilograms for weight.
4. **FirstNonRepeatingCharacter** — counts character frequencies with a `LinkedHashMap`, then scans left to right. Returns `\0` if no unique character exists.
5. **ReverseCustomerName** — reverses the input using a character array and leaves the original string unchanged.

## GitHub upload
Create an empty repository on GitHub, then run these commands from this directory:

```bash
git init
git add .
git commit -m "Add Day 1 Java practice solutions"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/YOUR-REPOSITORY.git
git push -u origin main
```

Replace the placeholder URL with your repository's actual HTTPS URL. If Git says `remote origin already exists`, use `git remote set-url origin YOUR-REPOSITORY-URL` instead.
