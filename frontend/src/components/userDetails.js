import { Button, Typography } from "@mui/material";
import { DataGrid, GridToolbar } from "@mui/x-data-grid";
import CheckIcon from "@mui/icons-material/Check";
import ClearIcon from "@mui/icons-material/Clear";
import { useEffect, useState } from "react";
import {LoanApplicationService} from "../components/LoanApplicationService";



const UserDetails = () => {
  const [user, setUser] = useState([]);

  const updateDataApproved = (params) => {
    console.log(params);
    console.log(params.row.status);
    console.log(params.row.id);
    const id = params.row.id;
    console.log(id);
    LoanApplicationService.updateApproved(params.row.id, {"status": "Approved"}).then(() => {
      LoanApplicationService.getAll()
      .then((result) => {
          if(user){
        console.log(result.data)
        setUser(result.data);
          }})
      .catch((error) => {
        console.log(error);
      });
    })
    // axios.post(`http://localhost:5000/user/update/${params.row._id}`, {
    //   status: "Approved",
    // });
  };
  
  const updateDataRejected = (params) => {
    LoanApplicationService.updateRejected(params.row.id,{"status":"Rejected"}).then(() => {
      LoanApplicationService.getAll()
      .then((result) => {
          if(user){
        console.log(result.data)
        setUser(result.data);
          }})
      .catch((error) => {
        console.log(error);
      });
    })
    // axios.post(`http://localhost:5000/user/update/${params.row._id}`, {
    //   status: "Rejected",
    // });
  };
  
  const confirmationApproval = () => {
    return window.confirm("*Are you sure you want to Approve the application?");
  };
  
  const confirmationRejection = () => {
    return window.confirm("*Are you sure you want to Reject the application?");
  };
  
  const columns = [
    //{field:'_id', headerName:'ID'},
    {
      field: "fname",
      headerName: "First Name",
      headerAlign: "center",
      align: "center",
    },
    {
      field: "lname",
      headerName: "Last Name",
      headerAlign: "center",
      align: "center",
    },
    {
      field: "email",
      headerName: "Email",
      headerAlign: "center",
      align: "center",
      width: 200,
    },
    {
      field: "lamount",
      headerName: "Loan Amount($)",
      headerAlign: "right",
      align: "right",
      width: 150,
    },
    {
      field: "lpurpose",
      headerName: "Loan Purpose",
      headerAlign: "center",
      align: "center",
    },
    { field: "sa1", headerName: "Address" },
    { field: "city", headerName: "City", headerAlign: "center", align: "center" },
    {
      field: "status",
      headerName: "Status",
      headerAlign: "center",
      align: "center",
    },
    {
      field: "approve",
      headerName: "Approve",
      headerAlign: "center",
      align: "center",
      width: 150,
      sortable: false,
      renderCell: (params) => {
        if (params.row.status !== "Pending") {
          return "";
        } else {
          return (
            <Button
              variant="contained"
              color="success"
              startIcon={<CheckIcon />}
              onClick={() => {
                if (confirmationApproval()) {
                  updateDataApproved(params);
                }
              }}
            >
              Approve
            </Button>
          );
        }
      },
    },
    {
      field: "reject",
      headerName: "Reject",
      width: 150,
      headerAlign: "center",
      align: "center",
      sortable: false,
      renderCell: (params) => {
        if (params.row.status !== "Pending") return "";
        else {
          return (
            <Button
              variant="contained"
              color="error"
              startIcon={<ClearIcon />}
              onClick={() => {
                if (confirmationRejection()) {
                  updateDataRejected(params);
                }
              }}
            >
              Reject
            </Button>
          );
        }
      },
    },
  ];

  // const getUser = () => {
    
  // }
  useEffect(() => {
    LoanApplicationService.getAll()
    .then((result) => {
        if(user){
      console.log(result.data)
      setUser(result.data);
        }})
    .catch((error) => {
      console.log(error);
    });
  }, []);
  return (
    <div>
      <Typography variant="h2" mx={2} my={2} align="center">
        User Details
      </Typography>
      <DataGrid
        rows={user}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        getRowId={(row) => row.id}
        autoHeight
        autoPageSize
        components={{ Toolbar: GridToolbar }}
        checkboxSelection
      />
    </div>
  );
};
export default UserDetails;
