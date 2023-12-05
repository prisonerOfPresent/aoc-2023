const std = @import("std");

pub fn main() !void {
    const stdout = std.io.getStdOut().writer();
    const fileContents = @embedFile("input.txt");
    for (fileContents) |line| {
        try stdout.print("{c}", .{line});
        //var firstDigit = undefined;
        //var lastDigit = undefined;
        for (line) |character| {
            try stdout.print("{c}", .{character});
        }
    }
    const hello = "hello";
    try stdout.print("{s}", .{hello});
}
