import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

function createData(
    name: string,
) {
    return { name };
}

const rows = [
    createData('Čeština A1'),
    createData('Čeština A2'),
    createData('Čeština B1'),
    createData('Čeština B2'),
    createData('Čeština C1'),
    createData('Angličtina A1'),
    createData('Angličtina A2'),
    createData('Angličtina B1'),
    createData('Angličtina B2'),
    createData('Angličtina C1'),
    createData('Němčina A1'),
    createData('Němčina A2'),
    createData('Němčina B1'),
    createData('Němčina B2'),
    createData('Němčina C1'),
    createData('Nizozemština A1'),
    createData('Nizozemština A2'),
    createData('Nizozemština B1'),
    createData('Nizozemština B2'),
];

export default function BasicTable() {
    return (
        <TableContainer component={Paper}>
            <Table sx={{ minWidth: 650 }} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell>Available Courses</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {rows.map((row) => (
                        <TableRow
                            key={row.name}
                            sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                        >
                            <TableCell component="th" scope="row">
                                {row.name}
                            </TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}
