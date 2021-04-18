package main

import (
	"fmt"
)

func main() {
	var S string
	fmt.Scan(&S)

	var result string
	for range make([]int, len(S)) {
		result += "x"
	}
	fmt.Println(result)
}
