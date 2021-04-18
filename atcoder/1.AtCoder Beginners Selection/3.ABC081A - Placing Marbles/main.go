package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	var s string
	fmt.Scan(&s)
	arr := strings.Split(s, "")
	sum := 0
	for _, a := range arr {
		n, _ := strconv.Atoi(a)
		sum += n
	}
	fmt.Println(sum)
}
