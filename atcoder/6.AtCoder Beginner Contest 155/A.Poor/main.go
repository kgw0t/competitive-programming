package main

import (
	"fmt"
)

func main() {
	var A, B, C int
	fmt.Scan(&A, &B, &C)

	var result string
	if A == B {
		if B == C {
			result = "No"
		} else {
			result = "Yes"
		}
	} else if B == C {
		result = "Yes"
	} else if A == C {
		result = "Yes"
	} else {
		result = "No"
	}
	fmt.Println(result)
}
